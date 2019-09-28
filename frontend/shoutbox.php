<?php
if(isset($_POST['name']) and isset($_POST['text']) 
and $_POST['name'] != "" and $_POST['name'] != "Dein Name?" 
and $_POST['text'] != "" and $_POST['name'] != "Dein Text?") {
   $dom = new DOMDocument("1.0", "UTF-8");
   if(!$dom)
      exit("FEHLER(1)!");
   $dom->preserveWhiteSpace = false;
   if(!$dom->load("shoutbox.xml")) {
      $shoutbox = $dom->createElement("shoutbox");
      $dom->appendChild($shoutbox);
   }
   $new_entry_elem = $dom->createElement("entry");
   $new_entry_elem->setAttribute("datetime", date("Y-m-d H:i"));
   $new_name_elem = $dom->createElement("name", 
                    substr($_POST['name'], 0, 256));
   $new_text_elem = $dom->createElement("text", 
                    substr($_POST['text'], 0, 1024));
   $new_entry_elem->appendChild($new_name_elem);
   $new_entry_elem->appendChild($new_text_elem);
   $shoutbox_elem = get_node($dom, '/shoutbox');
   if($shoutbox_elem->firstChild)
      $shoutbox_elem->insertBefore($new_entry_elem, 
                      $shoutbox_elem->firstChild);
   else
      $shoutbox_elem->appendChild($new_entry_elem);
   $i = 0;   
   $entry_elems = $dom->getElementsByTagName('entry');
   if($entry_elems->length > 10)
       $shoutbox_elem->removeChild($shoutbox_elem->lastChild);
   $dom->save("shoutbox.xml");
}
$content = file_get_contents("shoutbox.xml");
header('Content-Type: text/xml');
header("Last-Modified: " . gmdate("D, d M Y H:i:s") . " GMT");
header("Cache-Control: no-store, no-cache, must-revalidate");
echo $content;
 
function get_node($dom, $xpath) {
   $path = new DOMXPath($dom);
   $nodes = @$path->query($xpath);
   if(!is_object($nodes))
      return(false);
   else
      return($nodes->item(0));
}
?>