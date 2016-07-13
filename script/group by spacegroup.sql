use fedb;

select _symmetry_space_group_name_Hall,_space_group_IT_number from compound 
where _symmetry_space_group_name_Hall is not null and _space_group_IT_number is not null 

group by _symmetry_space_group_name_Hall,_space_group_IT_number
order by _space_group_IT_number
; 
