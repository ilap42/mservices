package com.tutoria.user.mservice.service;


import com.tutoria.user.mservice.entity.User;
import com.tutoria.user.mservice.feignclients.BikeFeignClient;
import com.tutoria.user.mservice.feignclients.CarFeignClient;
import com.tutoria.user.mservice.model.Bike;
import com.tutoria.user.mservice.model.Car;
import com.tutoria.user.mservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CarFeignClient carFeignClient;

    @Autowired
    BikeFeignClient bikeFeignClient;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew = userRepository.save(user);
        return userNew;
    }

    //PARA USAR CON REST TEMPLATE CAR
    public List<Car> getCars(int userId){
        //List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/"+userId, List.class); //Cambio Realizado con eureka
        List<Car> cars = restTemplate.getForObject("http://car-mservice/car/byuser/"+userId, List.class);
        return cars;
    }
    //PARA USAR CON REST TEMPLATE BIKE
    public List<Bike> getBikes(int userId){
        //List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/"+userId, List.class); //Cambio Realizado con eureka
        List<Bike> bikes = restTemplate.getForObject("http://bike-mservice/bike/byuser/"+userId, List.class);
        return bikes;
    }

    //PARA USAR CON carfeighlient
    public Car saveCar(int userId, Car car){
        car.setUserId(userId);
        Car carNew = carFeignClient.save(car);
        return carNew;
    }
    //PARA USAR CON bikefeighclient
    public Bike saveBike(int userId, Bike bike){
        bike.setUserId(userId);
        Bike bikeNew = bikeFeignClient.save(bike);
        return bikeNew;
    }

    //PARA obtener todos los vehiculos de un usuario usando bikefeighclient y carfeighclient
    public Map<String, Object> getUserAndVehicles(int userId){
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            result.put("Mensaje", "No existe el usuario");
            return result;
        }
        result.put("User",user);
        List<Car> cars = carFeignClient.getCars(userId);
        if(cars.isEmpty()){
            result.put("Cars","Este Usuario no tiene coches");
        }else{
            result.put("Cars", cars);
        }

        List<Bike> bikes = bikeFeignClient.getBikes(userId);
        if(bikes.isEmpty()){
            result.put("Bikes","Este Usuario no tiene motos");
        }else{
            result.put("Bikes", bikes);
        }
        return result;
    }
}
