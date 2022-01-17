package ml.sunmonkey.micropost.service;

import ml.sunmonkey.micropost.common.ServiceResultEnum;
import ml.sunmonkey.micropost.dao.ContentDao;
import ml.sunmonkey.micropost.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    ContentDao contentDao;

    public String addContent(Content content) {
        if (content.getMessage().equals("")) {
            return ServiceResultEnum.MESSAGE_NULL.name();
        }
        contentDao.save(content);
        return ServiceResultEnum.SUCCESS_MESSAGE.name();
    }

    public List<Content> findContentByUserId(Long userId) {
        if (userId == null) {
            return null;
        }
        List<Content> contents = contentDao.findContentByUserId(userId);
        return contents;
    }

    public List<Content> findContents() {
        return (List<Content>) contentDao.findAll();
    }
}
