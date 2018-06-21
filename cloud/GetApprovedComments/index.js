const ratings = require("../repository/ratings");

module.exports = function (context, req) {
    if (req.query.accomodation) {
        ratings.getApprovedComments(req.query.accomodation).then(result => {
            context.res = {
                body: result,
                headers: {
                    "Content-type": "application/json"
                }
            }

            context.done();
        });
    } else {
        context.res = {
            status: 400,
            body: "Please pass an accomodation on the query string"
        };

        context.done();
    }
};