select email from listdetails where listno in
(select listno from list where listname in
(select listname from message where status = 0 ))
/
