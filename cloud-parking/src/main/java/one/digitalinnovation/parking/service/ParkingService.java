package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import one.digitalinnovation.parking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository)
    {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> findAll()
    {

        return parkingRepository.findAll();

    }

    private static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id)
    {

        return parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));

    }

    public Parking create(Parking parkingCreate)
    {
        String uuid = getUUID();

        parkingCreate.setId(getUUID());

        parkingCreate.setEntryDate(LocalDateTime.now());

        parkingRepository.save(parkingCreate);

        return parkingCreate;
    }

    public void delete(String id)
    {
        findById(id);

        parkingRepository.deleteById(id);


    }

    public Parking update(String id, Parking parkingCreate)
    {
        Parking parking = findById(id);

        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());

        parkingRepository.save(parking);

        return parking;

    }

    public Parking exit(String id)
    {
        return null;
    }

}
