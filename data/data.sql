INSERT INTO categorie(libelle) VALUES
                     ('Table'),
                     ('Chaise');

INSERT INTO materiel(libelle) VALUES
                    ('Bois precieux'),
                    ('Tissus somptueux'),
                    ('Ornements decoratifs'),
                    ('Bois de chene'),
                    ('Contreplaque'),
                    ('Bois recupere'),
                    ('Rotin');

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
                          (3,6),
                          (3,7);