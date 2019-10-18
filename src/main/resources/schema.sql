DROP TABLE IF EXISTS TBL_EMPLOYEES;
  
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);


--
-- Table structure for table `assignmentuser`
--
CREATE TABLE IF NOT EXISTS `assignmentuser` (
  `assignmentid` int(11) NOT NULL,
  `studentid` int(11) NOT NULL,
  `username` varchar(128) NOT NULL,
  `dueon` datetime DEFAULT NULL,
  `availableon` datetime DEFAULT NULL,
  `startindex` int(5) DEFAULT NULL,
  `shift` int(5) DEFAULT NULL,
  `isdeleted` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`assignmentid`,`studentid`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `assignment`
--
CREATE TABLE IF NOT EXISTS `assignment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UUID` varchar(128) DEFAULT NULL,
  `label` varchar(256) DEFAULT NULL,
  `type` varchar(45) NOT NULL DEFAULT 'MARKED',
  `classid` int(11) NOT NULL,
  `assignedby` int(11) DEFAULT NULL,
  `availableon` datetime DEFAULT NULL,
  `dueon` datetime DEFAULT NULL,
  `releasedate` datetime DEFAULT NULL,
  `assignedon` datetime DEFAULT NULL,
  `teachernotes` varchar(255) DEFAULT NULL,
  `questionmaxattempts` mediumint(11) DEFAULT NULL,
  `showmarks` smallint(1) DEFAULT NULL,
  `showanswer` smallint(1) DEFAULT NULL,
  `showsolution` smallint(1) DEFAULT NULL,
  `autosubmitstatus` tinyint(1) DEFAULT NULL,
  `feedbackreleaseon` varchar(64) DEFAULT NULL,
  `itemsource` smallint(1) DEFAULT NULL,
  `assignedwholeclass` smallint(1) DEFAULT '0',
  `version` int(11) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=509 DEFAULT CHARSET=utf8;
