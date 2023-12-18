INSERT INTO unite(libelle) VALUES
                 ('metres cubes'),
                 ('metres carres'),
                 ('unite'),
                 ('feuilles'),
                 ('metres');

INSERT INTO categorie(libelle) VALUES
                     ('Table'),
                     ('Chaise');

INSERT INTO materiel(libelle,id_unite) VALUES
                    ('Bois precieux',1),
                    ('Tissus somptueux',2),
                    ('Ornements decoratifs',3),
                    ('Bois de chene',1),
                    ('Contreplaque',4),
                    ('Bois recupere',1),
                    ('Rotin',5),
                    ('Tissu',5),
                    ('Perle',3),
                    ('Chaine',3);

INSERT INTO style (libelle) VALUES
                    ('royal'),
                    ('scandinave'),
                    ('boheme'),
                    ('contemporain');

INSERT INTO volume (libelle) VALUES
                    ('Petit'),
                    ('Moyen'),
                    ('Grand');

INSERT INTO style_materiel(id_style,id_materiel) VALUES
                          (1,1),
                          (1,2),
                          (1,3),
                          (2,4),
                          (2,5),
                          (3,8),
                          (3,9),
                          (3,10);

INSERT INTO meuble(id_categorie,id_style,id_volume,prix) VALUES
                  (2,3,1,100000),
                  (2,3,3,200000);

INSERT INTO fabrication(id_style_materiel,id_categorie,id_volume,quantite) VALUES
                        (6,1,1,2),
                        (6,1,3,4),
                        (7,1,1,10),
                        (7,1,3,30),
                        (8,1,1,3),
                        (8,1,3,5);