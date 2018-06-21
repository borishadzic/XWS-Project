const ratings = require('../repository/ratings');

module.exports = function(context, req) {
    ratings.addRating(req.body).then(() => {
        context.res = {
            body: "Rating submited",
            headers: {
                "Content-Type": "text/plain"
            }
        };
    
        context.done();
    }).catch(() => {
        context.res = {
            status: 400,
            body: "Error while submiting rating"
        };
    
        context.done();
    });
};