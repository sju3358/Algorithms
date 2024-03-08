SELECT AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM ANIMAL_INS AI
    JOIN ANIMAL_OUTS AO ON AI.ANIMAL_ID = AO.ANIMAL_ID 
WHERE AI.SEX_UPON_INTAKE LIKE 'Intact%' 
AND (AO.SEX_UPON_OUTCOME LIKE 'Spayed%' OR AO.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY AI.ANIMAL_ID