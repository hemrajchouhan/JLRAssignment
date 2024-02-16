import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  stages: [
    { duration: '1m', target: 10 }, // Ramp up to 10 users over 1 minute
    { duration: '3m', target: 10 }, // Maintain 10 users for 3 minutes
    { duration: '1m', target: 0 },  // Ramp down to 0 users over 1 minute
  ],
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95% of requests must complete within 500ms
  },
};

export default function () {
  // Send a GET request to the pet endpoint
  let response = http.get('https://petstore.swagger.io/v2/pet/1');
  
  // Check if the response is successful
  check(response, {
    'status is 200': (r) => r.status === 200,
  });
  
  // Sleep for a random duration between 1 and 3 seconds
  sleep(Math.random() * 2 + 1);
}
