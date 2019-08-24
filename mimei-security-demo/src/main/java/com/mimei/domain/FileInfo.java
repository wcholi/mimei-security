package com.mimei.domain;

import lombok.Data;

/**
 * @author wuchongliang
 * @create 2019-08-24 11:18:15
 * @description:
 */
@Data
public class FileInfo {

    private String path;

    public FileInfo(String path) {
        this.path = path;
    }
}
