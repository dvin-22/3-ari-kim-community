package kr.adapterz.ari_community.post.dto.request;

import lombok.Getter;

@Getter
public class CreateOrUpdatePostRequest {

    private String title;

    private String content;

    private String image_url;

}
