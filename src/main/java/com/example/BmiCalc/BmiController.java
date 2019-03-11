package com.example.BmiCalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BmiController {
    private static double weight = 1, height = 1;
    private static double BMIRounded = 0.0;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(ModelMap model) {
      UserDetails userDetails = new UserDetails();
      model.addAttribute("userDetails", userDetails);

      return "bmi";
  }

    @PostMapping("/")
    public String calculateBMIButtonPressed(@ModelAttribute(value = "userDetails") UserDetails userDetails){

        System.out.println("Twoja waaga "+userDetails.getUserWeight());
        System.out.println("Twój wzrost "+userDetails.getUserHeight());

        double BMI = calculateBMI(userDetails.getUserWeight(), userDetails.getUserHeight());
        System.out.println("Twoje BMI wynosi " + BMI);
        userDetails.setUserBMI(BMI);
        //set user health category
        if(BMI < 16.0){
            userDetails.setUserHealthCategory("Niedowaga III");
        }else if(BMI >= 16.0 && BMI <= 16.9){
            userDetails.setUserHealthCategory("Niedowaga II");
        }else if(BMI >= 17.0 && BMI <= 18.4){
            userDetails.setUserHealthCategory("Niedowaga");
        }else if (BMI >= 18.5 && BMI <= 24.9){
            userDetails.setUserHealthCategory("Normalne");
        }else if(BMI >= 25.0 && BMI <= 29.9){
            userDetails.setUserHealthCategory("Nadwaga");
        }else if(BMI >= 30.0 && BMI <= 34.9){
            userDetails.setUserHealthCategory("Otyłość I");
        }else if(BMI >=35.0 && BMI <= 39.9){
            userDetails.setUserHealthCategory("Otyłość II");
        }else if(BMI >= 40.0){
            userDetails.setUserHealthCategory("Otyłość III");
        }
        System.out.println(" " + userDetails.getUserHealthCategory());


        return "bmi";

    }
    private static double calculateBMI(Double userWeight, Double userHeight){

        weight = userWeight;
        height = userHeight;
        height = userHeight/100;
        BMIRounded = Math.round(weight  / (height * height));
        return BMIRounded;
    }}


