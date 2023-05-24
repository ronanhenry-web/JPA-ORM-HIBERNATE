package org.petstore.entities;

import javax.persistence.Entity;

@Entity
public class Fish extends AbstractAnimal {
    private FishLivEnv fishlivenv;

    public Fish() {
    }

    public FishLivEnv getFishlivenv() {
        return fishlivenv;
    }

    public void setFishlivenv(FishLivEnv fishlivenv) {
        this.fishlivenv = fishlivenv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "fishlivenv=" + fishlivenv +
                '}';
    }
}
