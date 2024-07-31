package com.dorandoran.backend.File.exception;

public enum ErrorCode {
    EMPTY_FILE_EXCEPTION("파일이 비어 있습니다."),
    IO_EXCEPTION_ON_IMAGE_UPLOAD("이미지 업로드 중 IO 예외 발생."),
    NO_FILE_EXTENSION("파일 확장자가 없습니다."),
    INVALID_FILE_EXTENSION("유효하지 않은 파일 확장자입니다."),
    PUT_OBJECT_EXCEPTION("S3 객체를 추가하는 데 실패했습니다."); // 추가된 부분


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}