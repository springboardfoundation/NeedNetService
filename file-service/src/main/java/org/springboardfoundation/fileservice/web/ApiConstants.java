package org.springboardfoundation.fileservice.web;

public class ApiConstants {

    public static final String FILE_PATH_SEGMENT = "file";
    // request params
    public static final String FILE_PARAM = "file";
    public static final String NEEDID_PARAM = "needId";
    public static final String ASSETID_PARAM = "assetId";
    // api paths
    public static final String ID_PATH = "id";
    public static final String BASE_PATH = "/api/v1/fs";
    public static final String UPLOAD_PATH = "/file";
    public static final String DOWNLOAD_PATH = BASE_PATH + "/" + FILE_PATH_SEGMENT + "/{id}";

    private ApiConstants() {
        throw new UnsupportedOperationException("Cannot instantiate a constants class");
    }
}