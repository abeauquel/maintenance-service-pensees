<?php
include "../../accesseur/PenseeDAO.php";
$penseeDAO = new PenseeDAO();
//print_r($penseeDAO);
$listePensees = $penseeDAO->listerPensees();
//print_r($listePensees);
$indexAleatoire = rand(0, count($listePensees) - 1);
$pensee = $listePensees[$indexAleatoire];

?><?php
header("Content-type: text/xml");
echo '<?xml version="1.0" encoding="UTF-8"?>';
?>
<pensee>
    <auteur><?=(utf8_decode($pensee->auteur))?></auteur>
    <message><?=(utf8_decode($pensee->message))?></message>
    <annee><?=$pensee->annee?></annee>
    <id><?=$pensee->idPensee?></id>
</pensee>