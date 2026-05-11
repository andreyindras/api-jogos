INSERT INTO jogos (nome, tipo, nota, review)
SELECT 'The Legend of Zelda', 'Aventura', 10, 'Um clássico absoluto.'
WHERE NOT EXISTS (
    SELECT 1 FROM jogos WHERE nome = 'The Legend of Zelda'
);

INSERT INTO jogos (nome, tipo, nota, review)
SELECT 'FIFA 23', 'Esporte', 7, 'Bom para jogar com amigos.'
WHERE NOT EXISTS (
    SELECT 1 FROM jogos WHERE nome = 'FIFA 23'
);