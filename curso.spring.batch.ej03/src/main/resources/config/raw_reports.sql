DROP TABLE RAW_REPORT;
CREATE TABLE RAW_REPORT (
	DATE DATE NOT NULL,
	IMPRESSIONS DOUBLE NOT NULL,
	CLICKS DOUBLE NOT NULL,
	EARNING DOUBLE NOT NULL
) ENGINE=InnoDB;
