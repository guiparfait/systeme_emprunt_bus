
printf "\n*** INIT ***\n"

curl http://localhost:8124/voyageurs

curl -X POST -H 'Content-type:application/json' -H 'Accept:application/json' -d '{"name":"peter", "state":"avec_billet"}' http://localhost:8124/voyageurs
curl -X POST -H 'Content-type:application/json' -H 'Accept:application/json' -d '{"name":"carlos", "state":"sans_billet"}' http://localhost:8124/voyageurs

printf "\n*** VOYAGEUR***\n"
curl http://localhost:8124/voyageurs


printf "\n*** GET VOYAGEUR ***\n"

curl http://localhost:8124/voyageurs/0
curl http://localhost:8124/voyageurs/1


curl -X POST -H 'Content-type:application/json' -H 'Accept:application/json' -d '{"immatriculation":"BA-302-41", "statuts":"stationné"}' http://localhost:8124/bus
curl -X POST -H 'Content-type:application/json' -H 'Accept:application/json' -d '{"immatriculation":"BF-306-42", "status":"en_voyage"}' http://localhost:8124/bus

printf "\n*** BUS***\n"
curl http://localhost:8124/bus