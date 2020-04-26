package rest.infrastructure;

public class UserException extends RuntimeException {
    public Integer status;
    public String code;
    public String[] msgParameters;

    public static final int BUSINESS_STATUS = 422;
    public static final int INVALID_PAYLOAD = 400;
    public static final int NOT_FOUND = 404;

    public static class UserBusinessException extends UserException {
        public UserBusinessException(String code, String[] msgParameters) {
            this.code = code;
            this.status = BUSINESS_STATUS;
            this.msgParameters = msgParameters;
        }

        public UserBusinessException(String code) {
            this.code = code;
            this.status = BUSINESS_STATUS;
            this.msgParameters = null;
        }
    }

    public class UserInvalidPayloadException extends UserException {
        public UserInvalidPayloadException(String code, String[] msgParameters) {
            this.code = code;
            this.status = INVALID_PAYLOAD;
            this.msgParameters = msgParameters;
        }

        public UserInvalidPayloadException(String code) {
            this.code = code;
            this.status = INVALID_PAYLOAD;
            this.msgParameters = null;
        }
    }

    public class UserNotFoundException extends UserException {
        public UserNotFoundException(String code, String[] msgParameters) {
            this.code = code;
            this.status = NOT_FOUND;
            this.msgParameters = msgParameters;
        }

        public UserNotFoundException(String code) {
            this.code = code;
            this.status = NOT_FOUND;
            this.msgParameters = null;
        }
    }
}
