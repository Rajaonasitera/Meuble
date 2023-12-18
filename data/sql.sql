CREATE DATABASE meuble;
\c meuble

CREATE TABLE unite(
    id_unite SERIAL PRIMARY KEY,
    libelle VARCHAR(50)
);

CREATE TABLE categorie(
    id_categorie SERIAL PRIMARY KEY,
    libelle VARCHAR(50)
);

CREATE TABLE materiel(
    id_materiel SERIAL PRIMARY KEY,
    libelle VARCHAR(50),
    id_unite INT REFERENCES unite(id_unite)
);

CREATE TABLE style(
    id_style SERIAL PRIMARY KEY,
    libelle VARCHAR(50)
);

CREATE TABLE volume(
    id_volume SERIAL PRIMARY KEY,
    libelle VARCHAR(50)
);

CREATE TABLE meuble(
    id_meuble SERIAL PRIMARY KEY,
    id_categorie INT REFERENCES categorie(id_categorie),
    id_style INT REFERENCES style(id_style),
    id_volume INT REFERENCES volume(id_volume),
    prix DECIMAL
);

CREATE TABLE style_materiel(
    id_style_materiel SERIAL PRIMARY KEY,
    id_style INT REFERENCES style(id_style),
    id_materiel INT REFERENCES materiel(id_materiel)
);

CREATE TABLE fabrication(
    id_fabrication SERIAL PRIMARY KEY,
    id_style_materiel INT REFERENCES style_materiel(id_style_materiel),
    id_categorie INT REFERENCES categorie(id_categorie),
    id_volume INT REFERENCES volume(id_volume),
    quantite DECIMAL
);






