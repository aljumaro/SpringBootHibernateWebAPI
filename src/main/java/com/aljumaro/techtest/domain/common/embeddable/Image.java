package com.aljumaro.techtest.domain.common.embeddable;

import com.aljumaro.techtest.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Date 16/04/2016
 * @Time 16:44
 * @Author Juanma
 */
@Embeddable
public class Image{

    @Size(
            min = 5,
            max = 50
    )
    protected String title;

    @NotNull
    @Size(
            min = 5,
            max = 100
    )
    @Column(nullable = false)
    protected String fileName;

    protected int width;

    protected int height;

    protected Image(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Image image = (Image) o;

        if (width != image.width) return false;
        if (height != image.height) return false;
        if (title != null ? !title.equals(image.title) : image.title != null) return false;
        return fileName.equals(image.fileName);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + fileName.hashCode();
        result = 31 * result + width;
        result = 31 * result + height;
        return result;
    }
}
