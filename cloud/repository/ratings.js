const mysql = require("mysql");

const con = mysql.createConnection({
    host: "localhost",
    user: "bookingxws",
    password: "123456",
    database: "cloud",
    typeCast: function castField(field, useDefaultTypeCasting) {
        if (field.type === "BIT" && field.length === 1) {
            var bytes = field.buffer();
            return (bytes[0] === 1);
        }

        return (useDefaultTypeCasting());
    }
});

con.connect(function (err) {
    if (err) throw err;
    console.log("Connected!");
});

module.exports = {
    getRatings() {
        return new Promise((resolve, reject) => {
            con.query("SELECT accomodation_id AS accomodation, avg(rating) AS rating " 
                    + "FROM ratings GROUP BY accomodation_id", (err, result) => {
                if (err) reject(err);
                else resolve(result);
            });
        });
    },
    addRating(data) {
        return new Promise((resolve, reject) => {
            con.query("INSERT INTO ratings (accomodation_id, user_id, rating, comment, agent) VALUES (?, ?, ?, ?, ?)",
                [data.accomodation, data.user, data.rating, data.comment, data.agent], (err) => {
                    if (err) reject(err);
                    else resolve();
                }
            );
        });
    },
    getCommentsForAgent(agent) {
        return new Promise((resolve, reject) => {
            con.query("SELECT accomodation_id AS accomodation, comment, user_id AS user, rating " 
                    + "FROM ratings WHERE agent = ?", agent, (err, result) => {
                if (err) reject(err);
                else resolve(result);
            });
        });
    },
    getApprovedComments(accomodation) {
        return new Promise((resolve, reject) => {
            con.query("SELECT comment, rating " 
                    + "FROM ratings WHERE accomodation_id = ? AND approved = 1", accomodation, (err, result) => {
                if (err) reject(err);
                else resolve(result);
            });
        });
    },
    getCommentsForReview() {
        return new Promise((resolve, reject) => {
            con.query("SELECT id, comment, agent " 
                    + "FROM ratings where reviewed = 0", (err, result) => {
                if (err) reject(err);
                else resolve(result);
            });
        });
    },
    approveComment(id) {
        return new Promise((resolve, reject) => {
            con.query("UPDATE ratings SET approved = 1, reviewed = 1 WHERE id = ?", id, (err) => {
                if (err) reject(err);
                else resolve();
            });
        });
    },
    declineComment(id) {
        return new Promise((resolve, reject) => {
            con.query("UPDATE ratings SET approved = 0, reviewed = 1 WHERE id = ?", id, (err) => {
                if (err) reject(err);
                else resolve();
            });
        });
    }
}