package kr.adapterz.ari_community.post;

import jakarta.transaction.Transactional;
import kr.adapterz.ari_community.post.dto.request.CreateOrUpdatePostRequest;
import kr.adapterz.ari_community.user.User;
import kr.adapterz.ari_community.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    //public List<Post> getPostList() {};

    public Post getPost(BigInteger post_id) {
        return postRepository.findById(post_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("post not found"));
    }

    @Transactional
    public Post createPost(Integer user_id, CreateOrUpdatePostRequest request) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("user not found"));
        Post post = new Post(user,
                user.getNickname(),
                request.getTitle(),
                request.getContent(),
                request.getImage_url());
        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(BigInteger post_id, CreateOrUpdatePostRequest request) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("post not found"));
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setImage_url(request.getImage_url());
        return post;
    }

    @Transactional
    public void deletePost(BigInteger post_id) {
        Post post = postRepository.findById(post_id)
                .orElseThrow(() ->
                        new IllegalArgumentException("post not found"));
        postRepository.delete(post);
    }

}
