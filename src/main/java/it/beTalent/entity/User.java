package it.beTalent.entity;

import it.beTalent.decoretorPattern.BasicCamera;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String cameraType;
    private String subscriptionPlan;
    private List<String> features;


    //costruttore della classe user creato per correlare user a userBuilder costruttore
    public User(UserBuilder builder) {
        this.cameraType = builder.cameraType;
        this.subscriptionPlan = builder.subscriptionPlan;
        this.features = builder.features != null ? new ArrayList<>(builder.features) : new ArrayList<>();
    }

    public String getCameraType() {
        return cameraType;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public List<String> getFeatures() {
        return features;
    }

    @Override
    public String toString() {
        return "User{" +
                "cameraType='" + cameraType + '\'' +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                ", features=" + features +
                '}';
    }

    //userBuilder creato con Generetor Builder
    public static final class UserBuilder {
        private String cameraType;
        private String subscriptionPlan;
        private List<String> features;

        public UserBuilder() {
        }

        public UserBuilder(User other) {
            this.cameraType = other.cameraType;
            this.subscriptionPlan = other.subscriptionPlan;
            this.features = other.features;
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder cameraType(String cameraType) {
            this.cameraType = cameraType;
            return this;
        }

        public UserBuilder subscriptionPlan(String subscriptionPlan) {
            this.subscriptionPlan = subscriptionPlan;
            return this;
        }

        public UserBuilder features(List<String> features) {
            this.features = features;
            return this;
        }

        public UserBuilder addFeature(String feature) { if (this.features == null) { this.features = new ArrayList<>(); } this.features.add(feature); return this; }

        public UserBuilder but() {
            return anUser().cameraType(cameraType).subscriptionPlan(subscriptionPlan).features(features);
        }

        public User build() {
            return new User(this);
        }
    }
}
