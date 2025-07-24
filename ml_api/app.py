
from flask import Flask, request, jsonify
import pickle

app = Flask(__name__)

model = pickle.load(open("model.pkl", "rb"))

@app.route("/predict", methods=["GET"])
def predict():
    symptom = request.args.get("symptom")
    if symptom.lower() == "fever":
        return "You might have the flu"
    elif symptom.lower() == "headache":
        return "You might have migraine"
    else:
        return "Unknown symptom"

if __name__ == "__main__":
    app.run(debug=True)
