import axios from "axios";
// Note:
// Any user (both authenticated and unauthenticated) can search for products.
// Any STAFF member can update a product.
// Only Managers and above can create new products.
// Only Admin users can delete a product.

export default {
    register: function(user) {
        return postWithToken()
    },
    login: function(user) {
        return axios.post("/")
    },
    getGame: function() {
        return getWithOutToken()
    },
    getGames: function() {

    },
    updateGame: function() {

    },
    deleteGame: function() {

    },
    getTShirt: function() {

    },
    getTShirts: function() {

    },
    deleteTShirt: function() {

    },
    newOrder: function(orderData, token) {
    return postWithToken();
    }
}




// HELPER METHODS 
function postWithToken(suffix, data, token) {
  return axios.post(baseUrl + suffix, data, {
    headers: { Authorization: `Bearer ${token}` }
  });
}

function getWithToken(suffix, token) {
  return axios.get(baseUrl + suffix, {
    headers: { Authorization: `Bearer ${token}` }
  });
}

function getWithoutToken(suffix, data) {
  return axios.get(baseUrl + suffix, data)
}

function postWithoutToken(suffix, data) {
  return axios.post(baseUrl + suffix, data);
}