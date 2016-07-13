use shopdb;
DELIMITER $$  

CREATE PROCEDURE ABC(IN fullstr varchar(255),IN delim varchar(10))

   BEGIN
   
     
      DECLARE a INT Default 0 ;
      DECLARE str VARCHAR(255);
      
      
       CREATE TEMPORARY TABLE TempTable (splittedString varchar(100)) ;
      simple_loop: LOOP
         SET a=a+1;
         SET str=SPLIT_STR(fullstr,delim,a);
         IF str='' THEN
            LEAVE simple_loop;
         END IF;
         insert into TempTable values (str);
   END LOOP simple_loop;
   
   select * from TempTable;
   Drop table TempTable;
END $$