package org.skypro.counter.model.article;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.UUID;

public class Article implements org.skypro.counter.model.search.Searchable {
    private final String nameArticle;
    private final String textArticle;
    private final UUID id;

    public Article (String nameArticle, String textArticle, UUID id){
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
        this.id = id;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm(){
        return toString();
    }

    @JsonIgnore
    @Override
    public String getContentType(){
        return "Article";
    }


    @Override
    public String getName(){
        return nameArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle) && Objects.equals(textArticle, article.textArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArticle, textArticle);
    }

    @Override
    public String toString() {
        return "Название статьи " + nameArticle + "\n" + "Текст статьи: " + textArticle;
    }

    @Override
    public UUID getId() {
        return id;
    }
}
