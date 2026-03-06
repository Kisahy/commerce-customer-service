CREATE TABLE customers
(
    id           BIGINT       NOT NULL AUTO_INCREMENT COMMENT '고객 ID',
    email        VARCHAR(255) NOT NULL UNIQUE COMMENT '이메일',
    password     VARCHAR(255) NOT NULL COMMENT '비밀번호',
    name         VARCHAR(255) NOT NULL COMMENT '이름',
    mobile_phone VARCHAR(255) NOT NULL COMMENT '휴대폰 번호',
    status       VARCHAR(20)  NOT NULL COMMENT '고객 상태',
    created_at   DATETIME     NOT NULL COMMENT '생성일시',
    updated_at   DATETIME     NOT NULL COMMENT '수정일시',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='고객 테이블';