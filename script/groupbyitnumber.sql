select _space_group_IT_number
from fedb.compound
where _space_group_IT_number is not null
group by _space_group_IT_number
order by _space_group_IT_number

