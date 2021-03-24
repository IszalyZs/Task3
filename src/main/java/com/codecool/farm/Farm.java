package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {
    private List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        for (Animal animal : getAnimals()) {
            animal.feed();
        }
    }

    public void butcher(Butcher butcher) {
        for (int i = 0; i < animals.size(); i++) {
            if (butcher.canButcher(animals.get(i))) {
                animals.remove(animals.get(i));
                i--;
            }
        }
    }

    public boolean isEmpty() {
        if (getAnimals().size() == 0) return true;
        else return false;
    }

    public List<String> getStatus() {
        List<String> statusLists = new ArrayList<>();
        String typeOfAnimal;
        for (Animal animal : getAnimals()) {
            if (animal instanceof Pig)
                typeOfAnimal = "pig";
            else typeOfAnimal = "cattle";
            statusLists.add(String.format("There is a %d sized %s in the farm.", animal.getSize(), typeOfAnimal));
        }
        return statusLists;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
