package one.digitalinnovation.parking.service;

import one.digitalinnovation.parking.exception.ParkingNotFoundException;
import one.digitalinnovation.parking.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static
    {
        var id  = getUUID();
        var id1  = getUUID();
        Parking parking = new Parking(id, "ABC-000", "RS", "oNIX", "BRANCO");
        Parking parking1 = new Parking(id1, "ABC-123", "RS", "oNIX", "BRANCO");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }

    public List<Parking> findAll()
    {
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public Parking findById(String id)
    {
        Parking parking = parkingMap.get(id);
        if(parking == null)
        {
            throw new ParkingNotFoundException(id);
        }
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate)
    {
        String uuid = getUUID();

        parkingCreate.setId(getUUID());

        parkingCreate.setEntryDate(LocalDateTime.now());

        parkingMap.put(uuid, parkingCreate);

        return parkingCreate;
    }
}
