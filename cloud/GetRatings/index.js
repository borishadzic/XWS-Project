const ratings = require('../repository/ratings');

module.exports = function(context) {
    ratings.getRatings().then(result => {
        context.res = {
            headers: {
                "Content-Type": "application/json"
            },
            body: result
        };

        context.done();
    });
}; 