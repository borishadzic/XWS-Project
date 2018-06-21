const ratings = require("../repository/ratings");

module.exports = function (context, req) {
    if (req.query.agent) {
        ratings.getCommentsForAgent(req.query.agent).then(data => {
            context.res = {
                body: data,
                headers: {
                    "Content-Type": "application/json"
                }
            }
            
            context.done();
        });
    } else {
        context.res = {
            status: 400,
            body: "Agent id must be passed on the query string"
        }

        context.done();
    }
};