CREATE OR REPLACE VIEW quantite AS
SELECT 
meuble.id_meuble,
fabrication.id_fabrication, 
fabrication.id_style_materiel as id_style_materiel,
style_materiel.id_style as id_style,
style_materiel.id_materiel as idMateriel,
fabrication.id_categorie,
fabrication.id_volume,
fabrication.quantite
from fabrication, style_materiel, meuble
where fabrication.id_style_materiel = style_materiel.id_style_materiel 
and style_materiel.id_style = meuble.id_style
and style_materiel.id_ = meuble.id_style
and fabrication.id_categorie = meuble.id_categorie 
and fabrication.id_volume = meuble.id_volume; 
