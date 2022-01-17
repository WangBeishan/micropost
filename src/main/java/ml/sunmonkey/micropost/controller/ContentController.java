package ml.sunmonkey.micropost.controller;

import ml.sunmonkey.micropost.common.Result;
import ml.sunmonkey.micropost.common.ResultGenerator;
import ml.sunmonkey.micropost.common.ServiceResultEnum;
import ml.sunmonkey.micropost.model.Content;
import ml.sunmonkey.micropost.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/post")
    public Result postContent(@RequestBody Content content) {
        String result = contentService.addContent(content);

        if (result.equals(ServiceResultEnum.SUCCESS_MESSAGE.name())) {
            return new ResultGenerator().successResult();
        }
        return new ResultGenerator().errorResult(result);
    }

    @GetMapping("/getContent")
    public Result findContentByUserId(@RequestParam("userId") Long userId) {
        List<Content> contents = contentService.findContentByUserId(userId);
        return new ResultGenerator<List<Content>>().successResult(contents);
    }

    @GetMapping("/getContents")
    public Result findContents() {
        List<Content> contents = contentService.findContents();
        return new ResultGenerator<List<Content>>().successResult(contents);
    }

}
