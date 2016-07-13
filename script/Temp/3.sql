use fedb;
DELIMITER $$

DROP PROCEDURE IF EXISTS SearchCompound $$
CREATE PROCEDURE SearchCompound 
   (IN aNo INT, IN showAll bit, IN spaceGroup int, IN crystalSystem varchar(20))
BEGIN
	Select _cod_database_code, _chemical_formula_sum,_space_group_IT_number,_symmetry_cell_setting
     , _symmetry_space_group_name_HM from compound 
    where atomicno = aNo 
    and (showAll=1 or
	((spaceGroup=0 or _space_group_it_number=spaceGroup)
    and (char_length(crystalSystem)=0 or _symmetry_cell_setting=crystalSystem))
    );
    
END $$

DELIMITER ;