DROP TABLE IF EXISTS sample;
CREATE TABLE sample (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	  data VARCHAR(100),
    type INT(100)
);

DROP TABLE IF EXISTS SKIP_ITEMS;
CREATE TABLE SKIP_ITEMS (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    jobExecutionId INT,
    stepExecutionId INT,
    jobName VARCHAR(100),
    type VARCHAR(100),
    item VARCHAR(100),
    msg VARCHAR(1000),
    runId INT
);

