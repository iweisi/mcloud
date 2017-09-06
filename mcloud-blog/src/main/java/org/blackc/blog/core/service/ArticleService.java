package org.blackc.blog.core.service;

import java.util.Objects;
import org.blackc.blog.core.dto.ArticleSearchRequest;
import org.blackc.blog.core.entity.Article;
import org.blackc.blog.core.repository.ArticleRepository;
import org.blackc.common.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article getArticle(String username, Long articleId) {
        Article article = articleRepository.findByUserAndId(username, articleId);
        if (Objects.isNull(article)) {
            throw new DataNotFoundException("article[id=" + articleId + "] not found");
        }
        return article;
    }

    public Page<Article> getArticlePage(ArticleSearchRequest searchRequest, Pageable pageable) {
        return articleRepository.findBySearchRequest(searchRequest, pageable);
    }
}
