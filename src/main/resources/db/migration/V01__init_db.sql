CREATE TABLE articles
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title      VARCHAR(100) NOT NULL,
    announce   VARCHAR(250) NOT NULL,
    full_text  TEXT         NOT NULL,
    created_at TIMESTAMPTZ  NOT NULL DEFAULT now()
);

CREATE TABLE categories
(
    id   BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE article_categories
(
    article_id  BIGINT NOT NULL REFERENCES articles(id) ON DELETE CASCADE,
    category_id BIGINT NOT NULL REFERENCES categories(id) ON DELETE CASCADE,

    PRIMARY KEY (article_id, category_id)
);