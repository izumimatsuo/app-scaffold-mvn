CREATE TABLE IF NOT EXISTS user_accounts (
	id BIGINT IDENTITY PRIMARY KEY,
	username VARCHAR NOT NULL UNIQUE,
	password VARCHAR NOT NULL,
	authority VARCHAR NOT NULL,
	enabled BOOLEAN NOT NULL DEFAULT TRUE,
	nickname VARCHAR
);

INSERT INTO user_accounts
    (username, password, authority, nickname)
VALUES
    ('guest', '$2a$10$eHsXtsL8Pm9N.qDlDB.0tu85neuYldEGWw4NsAu20P3b5cNqMVZEq', 'ROLE_GUEST', 'ゲストユーザ'),
    ('demo', '$2a$10$eHsXtsL8Pm9N.qDlDB.0tu85neuYldEGWw4NsAu20P3b5cNqMVZEq', 'ROLE_USER', 'デモユーザ'),
    ('admin', '$2a$08$vqxoAIAuSPigDzSxTxuJtenHj4L7chXMeijPz/Rtci5r9TElKrMUm', 'ROLE_USER ROLE_ADMIN', '管理ユーザ');

CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT IDENTITY PRIMARY KEY,
    title VARCHAR NOT NULL,
    memo VARCHAR,
    status CHAR(3) NOT NULL,
    createAt TIMESTAMP NOT NULL DEFAULT now()
);
