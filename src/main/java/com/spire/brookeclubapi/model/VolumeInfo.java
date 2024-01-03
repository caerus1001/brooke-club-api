package com.spire.brookeclubapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolumeInfo {
    private String title;
    private List<String> authors;
    private String publishedDate;
    private String description;
    private List<String> categories;
    private ImageLink imageLinks;
    private String language;
}
