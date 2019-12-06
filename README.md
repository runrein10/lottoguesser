# LottoPredictor
This is a skeleton of a lottery number predictor based-on MegaMillions Five ball, US.
For now it's concentrated on analysis of result history(#1~12). Various prediction models such as 

## Funtions
0. Basic structure of lottery numbers are controlled in LottoNumber.java and LottoHistory.java
1. Guessing new numbers by Prediction Models
2. Analyzing results of mass prediction.

## Classification
### LottoCollections
#### LottoNumber
Structure of 1 draft of lottery number
consists of 6 numbers and special number
#### LottoHistory
Structure of result history by date and turn, 6 drafted number and special number.
+ its state(is it a guess or history)
#### Result
2 Lotto numbers compared
- How many numbers were right
- What placing it is and at what draft turn
### PredictionModels
#### IPredictor
Interface class
#### PredictorModel
Abstract class for expandability to various models
#### FrequencyPredictor
Guessing new numbers by selecting 6 random numbers from N portion of numbers (ranked by number of appearance in history, at the time of draft)
#### UnfrequencyPredictor
Guessing new numbers by selecting 6 random numbers from N portion of numbers (ranked by number of 'IN'appearance in history, at the time of draft)
#### SyntheticPredictor(not available yet)
Guessing N numbers by X Predictor and 6-N numbers by Y Predictor

## MainRunner
an analysis app in javafx GUI for further upgrades, not yet complete.

## Development in progress
SyntheticPredictor, MainRunner.

+ it has been observed that unfrequency predictor has 17.97% more chance to win 5th placing. when N is 30.
++ feel free to add on.
