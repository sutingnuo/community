package com.springforum.suforum.Provider;

import com.alibaba.fastjson.JSON;
import com.springforum.suforum.dto.AccesstokenDTO;
import com.springforum.suforum.dto.GithubUser;
import okhttp3.*;

import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 代码整理：宋甜宁
 */
@Component
public class GithubProvider {
    public String getAccesstoken(AccesstokenDTO accesstokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
           String splitstr=string.split("&")[0].split("=")[1];
            return splitstr;
        } catch (Exception e) {
            e.printStackTrace();
        } return null;

    }


    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }

}
