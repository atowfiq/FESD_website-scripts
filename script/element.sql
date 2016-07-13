use fedb;
CREATE TABLE `element` (
  `name` varchar(30) DEFAULT NULL,
  `symbol` varchar(10) DEFAULT NULL,
  `atomicnumber` int(11) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  `period` int(11) DEFAULT NULL,
  `molarmass` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
