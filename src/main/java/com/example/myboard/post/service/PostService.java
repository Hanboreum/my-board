package com.example.myboard.post.service;

import com.example.myboard.board.db.BoardRepository;
import com.example.myboard.common.Api;
import com.example.myboard.common.Pagination;
import com.example.myboard.post.db.PostEntity;
import com.example.myboard.post.db.PostRepository;
import com.example.myboard.post.model.PostRequest;
import com.example.myboard.post.model.PostViewRequest;
import com.example.myboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(PostRequest postRequest) {

        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();//임시 고정값
        var entity = PostEntity.builder()
                .board(boardEntity)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .status("REGISTERED") //등록됨
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    /**
     * view는 두가지 검증
     * 게시글 유무
     * 비밀번호
     */
    public PostEntity view(PostViewRequest postViewRequest) {
       return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED") //registered된 것만 select
               .map( it->{
                   //entity가 존재 할때만
                   if(! it.getPassword().equals(postViewRequest.getPassword())){
                       //db에 있는 post의 pw와 입력 받은 post의 pw를ㄲㄷ 비교해 동일하지 않다면
                       var format = "비밀번호가 맞지 않습니다. %s vs %s ";
                       throw new RuntimeException(String.format(format,it.getPassword(), postViewRequest.getPassword()));
                   }

                   //답변 같이 보여주기.
                   // @OneToMany를 통해 자동으로 list를 보내 주므로 필요없어짐
                   //var replyList = replyService.findAllByPostId(it.getId());
                   //it.setReplyList(replyList);

                   return  it; //맞는다면 해당 entity  리턴




               }).orElseThrow( //데이터가 없다면
                       ()->{
                           return new RuntimeException("해당 게시글이 존재하지 않습니다."+ postViewRequest.getPostId());
                       }
               );
    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list =  postRepository.findAll(pageable);
        var pagination = Pagination.builder()
            .page(list.getNumber()) //현재 몇번째 페이지에 있는지
            .size(list.getSize())
            .currentElements(list.getNumberOfElements()) // 해당 페이지에 있는 엘리먼트 개수
            .totalElements(list.getTotalElements())
            .totalPage(list.getTotalPages())
            .build();
        var response = Api.<List<PostEntity>>builder()
            .body(list.toList())
            .pagination(pagination)
            .build();
        return response;
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    // entity 존재
                    if(!it.getPassword().equals(postViewRequest.getPassword())){
                        var format = "패스워드가 맞지 않습니다 %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }

                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        ()-> {
                            return new RuntimeException("해당 게시글이 존재 하지 않습니다 : "+postViewRequest.getPostId());
                        }
                );
    }
}
