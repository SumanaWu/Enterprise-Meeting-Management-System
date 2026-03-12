package org.example.identity.controller;
import lombok.Setter;
import lombok.Getter;

/**
 * used to as container for response to front;
 * Spring translate this POJO to Json automatically
 */
@Getter
@Setter
public class Resp {

    Integer code;
    String content;

    static Resp newInstance(Integer code, String content) {
        Resp resp = new Resp();
        resp.content = content;
        resp.code = code;
        return resp;
    }
}
