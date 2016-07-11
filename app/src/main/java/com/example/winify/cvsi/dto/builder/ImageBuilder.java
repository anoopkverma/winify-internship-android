package com.example.winify.cvsi.dto.builder;


import com.example.winify.cvsi.dto.ImageDto;
import com.example.winify.cvsi.model.Image;

/**
 * Created by Artemie on 04.07.2016.
 */
public class ImageBuilder {
    public ImageDto getImageDto(Image image)
    {
        ImageDto imageDto = new ImageDto();
        imageDto.setCreatedDate(image.getCreatedDate().getTime());
        imageDto.setImg(image.getImg());
        imageDto.setImgType(image.getImgType());
        return imageDto;
    }
}
